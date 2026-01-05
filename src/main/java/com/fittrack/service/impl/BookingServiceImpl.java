package com.fittrack.service.impl;

import com.fittrack.exception.BusinessException;
import com.fittrack.model.entity.Booking;
import com.fittrack.model.entity.User;
import com.fittrack.model.entity.WorkoutSession;
import com.fittrack.model.enums.BookingStatus;
import com.fittrack.dto.response.BookingResponse;
import com.fittrack.repository.BookingRepository;
import com.fittrack.repository.UserRepository;
import com.fittrack.repository.WorkoutSessionRepository;
import com.fittrack.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final WorkoutSessionRepository sessionRepository;

    @Override
    @Transactional
    public BookingResponse createBooking(Long studentId, Long sessionId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        WorkoutSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if (session.getBookings().size() >= session.getCapacity()) {
            throw new BusinessException("This session is already full");
        }

        Booking booking = new Booking();
        booking.setStudent(student);
        booking.setSession(session);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);

        Booking saved = bookingRepository.save(booking);

        return new BookingResponse(
                saved.getId(),
                student.getName(),
                session.getTitle(),
                session.getStartTime(),
                saved.getStatus()
        );
    }

    @Override
    public List<BookingResponse> getStudentHistory(Long studentId) {
        return bookingRepository.findByStudentId(studentId).stream()
                .map(b -> new BookingResponse(
                        b.getId(),
                        b.getStudent().getName(),
                        b.getSession().getTitle(),
                        b.getSession().getStartTime(),
                        b.getStatus()))
                .collect(Collectors.toList());
    }
}