INSERT INTO Employee (id, email, password, employeerole) VALUES
('1', 'worker@gmail.com', '123','WORKER'),
('2', 'manager@gmail.com', '456','MANAGER')
    ON CONFLICT (id) DO NOTHING;

/*     private Long ID;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole; */