package com.schedule.beautySalon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private String hairTreatment;
    private String professional;
    private String paymentMethod;
    private String paymentStatus;
    private String scheduleStatus;

    @ManyToOne
    @JoinColumn(name = "client_id") //chave estrangeira
    private Clients clients;

    public Schedule(){

    }

    public Schedule(Long id, LocalDate scheduledDate, LocalTime scheduledTime, String hairTreatment, String professional, String paymentMethod, String paymentStatus, String scheduleStatus, Clients clients){
        this.id = id;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.hairTreatment = hairTreatment;
        this.professional = professional;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.scheduleStatus = scheduleStatus;

        this.clients = clients;
    }

    public Clients getClients() {
        return clients;
    }
    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }
    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }
    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getHairTreatment() {
        return hairTreatment;
    }
    public void setHairTreatment(String hairTreatment) {
        this.hairTreatment = hairTreatment;
    }

    public String getProfessional() {
        return professional;
    }
    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }
    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}
