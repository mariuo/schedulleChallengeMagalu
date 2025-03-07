CREATE TABLE communication_schedules (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    scheduled_time TIMESTAMP NOT NULL,
    recipient VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    communication_type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
