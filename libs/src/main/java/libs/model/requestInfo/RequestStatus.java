package libs.model.requestInfo;

public enum RequestStatus {
  RECEIVED,       // Request received but not yet processed
  VALIDATING,     // CSV is being validated
  VALIDATION_FAILED, // Validation failed (e.g., incorrect format, authentication issue)
  VALIDATED,      // CSV validation successful
  PROCESSING,     // Images are being processed
  COMPLETED,      // All images have been processed successfully
  FAILED          // Processing failed
}