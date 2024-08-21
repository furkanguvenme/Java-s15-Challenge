package com.library;

import com.library.enums.ReaderType;
import com.library.enums.UserType;
import com.library.interfaces.WhoYouAre;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Member implements WhoYouAre {
    private long id;
    private String name;
    private String address;
    private String phoneNo;
    private UserType type;
    private LocalDate dateOfMembership;

    public Member(long id, String name, String address, String phoneNo, UserType type, LocalDate dateOfMembership) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
    }

    public long getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return id == member.id && Objects.equals(address, member.address) && Objects.equals(phoneNo, member.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, phoneNo);
    }
}
