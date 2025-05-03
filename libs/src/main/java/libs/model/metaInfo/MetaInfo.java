package libs.model.metaInfo;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaInfo {

  @NonNull
  protected Instant createAt;

  @NonNull
  protected Instant updatedAt;
  
}
