package com.example.Neural_Telemetry_Gateway.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    // Core Profile
    private String username;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String mailaddress;
    private String phoneNo;

    // AI & Time-Series Requirements
    private String timezone;           // Essential for aligning NIRS telemetry to local time
    private Double baselineEntropy;    // Resting baseline for ML anomaly detection
    
    // Security & Auditing
    private String role;               // e.g., "ROLE_USER"
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Relationship Mapping
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Device> devices;
    
    // Getters and Setters omitted for brevity
}
