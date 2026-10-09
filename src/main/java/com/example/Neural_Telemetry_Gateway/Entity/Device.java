package com.example.Neural_Telemetry_Gateway.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter 
public class Device {

    // Primary Key
    @Id
    private String macaddress;

    // Relationship Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // IoT Hardware Metadata
    private String deviceSecret; // For autonomous stream authentication (no user password required)
    private String firmwareVersion; // Crucial for tracking sampling rate changes in NIRS data
    private String deviceModel; // Used as a categorical feature in the XGBoost model

    // Status Tracking
    private LocalDateTime lastActive; // Updated to track battery drops or offline states
    private Boolean isActive; // Soft-delete flag for disabled/lost wearables

    // Getters and Setters omitted for brevity
}