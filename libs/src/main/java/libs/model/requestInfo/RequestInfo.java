package libs.model.requestInfo;

import libs.model.metaInfo.MetaInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestInfo extends MetaInfo {
  @NonNull
  private String requestId;

  @NonNull
  private String AccoutId;

  @NonNull
  private RequestStatus status;

  @NonNull
  private String description;
}
