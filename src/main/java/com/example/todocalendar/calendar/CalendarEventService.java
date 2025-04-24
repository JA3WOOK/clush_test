package com.example.todocalendar.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarEventService {
    private final CalendarEventRepository calendarEventRepository;

    public List<CalendarEvent> getAllEvents() {
        return calendarEventRepository.findAll();
    }

    public CalendarEvent getEventById(Long id) {
        return calendarEventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다. id=" + id));
    }

    public CalendarEvent createEvent(CalendarEvent event) {
        return calendarEventRepository.save(event);
    }

    public CalendarEvent updateEvent(Long id, CalendarEvent updated) {
        CalendarEvent event = getEventById(id);
        event.setTitle(updated.getTitle());
        event.setDescription(updated.getDescription());
        event.setStartTime(updated.getStartTime());
        event.setEndTime(updated.getEndTime());
        event.setLocation(updated.getLocation());
        return calendarEventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        calendarEventRepository.deleteById(id);
    }

    public CalendarEvent shareEvent(Long id, List<String> emails) {
        CalendarEvent event = getEventById(id);
        if (event.getSharedWithEmails() == null) {
            event.setSharedWithEmails(new ArrayList<>());
        }
        event.getSharedWithEmails().addAll(emails);
        return calendarEventRepository.save(event);
    }

}
