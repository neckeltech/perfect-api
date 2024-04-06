package tech.neckel.perfectApi.exception.errorResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int status;
    private String message;
    private Instant timestamp;
    private String strackTrace;

    public String toJson(){
        return "{\n" +
                "    \"status\": " + this.status + ",\n" +
                "    \"message\": \"" + this.message + "\",\n" +
                "    \"timestamp\": \"" + Instant.now() + "\"\n" +
                "}";
    }
}
