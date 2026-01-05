package com.fittrack.dto.response;

import com.fittrack.model.enums.BookingStatus;
import java.time.LocalDateTime;

public record BookingResponse(
        Long id,
        String studentName,
        String workoutTitle,
        LocalDateTime sessionTime,
        BookingStatus status
) {}
