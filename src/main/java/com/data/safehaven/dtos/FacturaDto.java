package com.data.safehaven.dtos;

import java.util.Date;

public record FacturaDto(Long id, double monto, String insertBy, String updateBy,
                         Date fechaDePago, Date insertAt, Date updateAt) {
}
