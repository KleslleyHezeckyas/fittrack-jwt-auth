package com.fittrack.service;

import com.fittrack.dto.response.BookingResponse;
import java.util.List;

public interface BookingService {
    BookingResponse createBooking(Long studentId, Long sessionId);
    List<BookingResponse> getStudentHistory(Long studentId);
}
