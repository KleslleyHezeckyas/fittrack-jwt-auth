package com.fittrack.controller.student;

import com.fittrack.dto.request.BookingRequest;
import com.fittrack.dto.response.BookingResponse;
import com.fittrack.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody @Valid BookingRequest request) {
        BookingResponse response = bookingService.createBooking(request.studentId(), request.sessionId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<BookingResponse>> getHistory(@PathVariable Long studentId) {
        return ResponseEntity.ok(bookingService.getStudentHistory(studentId));
    }
}