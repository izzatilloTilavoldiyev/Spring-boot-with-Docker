package uz.pdp.springbootwithdocker.dto;

import lombok.Builder;

@Builder
public record UserDTO(
        String name,
        Integer age
) {
}
