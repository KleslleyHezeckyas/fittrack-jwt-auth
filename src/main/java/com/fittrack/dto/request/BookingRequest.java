package com.fittrack.dto.request;

import jakarta.validation.constraints.NotNull;

public record BookingRequest(
    @NotNull Long studentId,
    @NotNull Long sessionId
) {}
