package ru.ryabtsev.enterprise.endpoint.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {
    final private boolean success;

    public ResultDTO() {
        this.success = false;
    }

    public ResultDTO(boolean isSuccess) {
        this.success = isSuccess;
    }
}
