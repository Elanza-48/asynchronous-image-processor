#!/bin/bash

set -x -e

if [ -z "$BASH_VERSION" ]; then
  echo "This script must be run in Bash!"
  exit 1
fi

echo "⏳ Waiting for Kafka to be ready..."
sleep 15s  # Ensure Kafka is ready before setting ACLs

echo "✅ Creating Kafka SCRAM-SHA-512 users..."

# Declare an associative array for users and passwords
declare -A USERS
USERS[admin]="admin-secret"
USERS[producer]="producer-secret"
USERS[consumer]="consumer-secret"

# Declare an associative array for users and passwords
declare -A HOSTS
HOSTS[kafka1]=19092
HOSTS[kafka2]=19093
HOSTS[kafka3]=19094


for host in "${!HOSTS[@]}"; do
  for user in "${!USERS[@]}"; do
    kafka-configs --bootstrap-server "$host:${HOSTS[$host]}" --alter --entity-type users --entity-name $user \
    --add-config "SCRAM-SHA-512=[password=${USERS[$user]}]"
  done
  kafka-configs --bootstrap-server "$host:${HOSTS[$host]}" --describe --entity-type users
done


# echo "✅ Creating Kafka ACLs..."
# Create ACLs for producer
# kafka-acls --bootstrap-server $KAFKA_BROKER \
#   --command-config /etc/kafka/admin.conf \
#   --add --allow-principal User:producer-user \
#   --operation Write --operation Describe \
#   --topic test-topic

# # Create ACLs for consumer
# kafka-acls --bootstrap-server $KAFKA_BROKER \
#   --command-config /etc/kafka/kafka_server_jaas.conf \
#   --add --allow-principal User:consumer-user \
#   --operation Read --operation Describe \
#   --group consumer-group

# Create ACLs for admin
# kafka-acls --bootstrap-server $KAFKA_BROKER \
#   --command-config /etc/kafka/kafka_server_jaas.conf \
#   --add --allow-principal User:admin \
#   --operation All --cluster
set +x +e