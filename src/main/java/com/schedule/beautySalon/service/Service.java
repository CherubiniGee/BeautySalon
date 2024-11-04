package com.schedule.beautySalon.service;

import com.schedule.beautySalon.model.Clients;
import com.schedule.beautySalon.model.Schedule;
import com.schedule.beautySalon.repository.ClientsRepository;
import com.schedule.beautySalon.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    public Schedule post(Schedule schedule) {
        if (schedule.getClients().getId() == null) {
            Clients savedClient = clientsRepository.save(schedule.getClients());
            schedule.setClients(savedClient);
        }
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> get() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getByDate(LocalDate scheduledDate) {
        return scheduleRepository.findByScheduledDate(scheduledDate);
    }

    public Optional<Schedule> getById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule update(Long id, Schedule updatedSchedule) {
        Schedule existingSchedule = scheduleRepository.findById(id).orElse(null);

        if (updatedSchedule.getClients() != null) {
            Long clientId = updatedSchedule.getClients().getId();
            if (clientId != null) {
                Clients existingClient = clientsRepository.findById(clientId).orElse(null);

                existingClient.setName(updatedSchedule.getClients().getName());
                existingClient.setContact(updatedSchedule.getClients().getContact());

                clientsRepository.save(existingClient);
                existingSchedule.setClients(existingClient);
            }
        }

        if (updatedSchedule.getScheduledDate() != null) {
            existingSchedule.setScheduledDate(updatedSchedule.getScheduledDate());
        }
        if (updatedSchedule.getScheduledTime() != null) {
            existingSchedule.setScheduledTime(updatedSchedule.getScheduledTime());
        }
        if (updatedSchedule.getHairTreatment() != null) {
            existingSchedule.setHairTreatment(updatedSchedule.getHairTreatment());
        }
        if (updatedSchedule.getProfessional() != null) {
            existingSchedule.setProfessional(updatedSchedule.getProfessional());
        }
        if (updatedSchedule.getPaymentMethod() != null) {
            existingSchedule.setPaymentMethod(updatedSchedule.getPaymentMethod());
        }
        if (updatedSchedule.getPaymentStatus() != null) {
            existingSchedule.setPaymentStatus(updatedSchedule.getPaymentStatus());
        }
        if (updatedSchedule.getScheduleStatus() != null) {
            existingSchedule.setScheduleStatus(updatedSchedule.getScheduleStatus());
        }

        return scheduleRepository.save(existingSchedule);
    }

}
