package com.example.demo.service;

import com.example.demo.database.MemberStorage;
import com.example.demo.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberStorage memberStorage;

    public MemberService() {
        this.memberStorage = new MemberStorage();
    }

    public ResponseEntity<List<MemberDto>> getMembers(String preferredName) {
        List<MemberDto> allMembers = memberStorage.getAllMembers();
        return ResponseEntity.ok(allMembers);
    }

    public ResponseEntity<MemberDto> getMember(Integer id) {
        MemberDto member = memberStorage.getMemberById(id);
        if (member != null) {
            return ResponseEntity.ok(member);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Integer> modifyMember(Integer id, MemberDto resource) {
        MemberDto member = memberStorage.getMemberById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        memberStorage.updateMember(id, resource);
        return ResponseEntity.ok(id);
    }

    public ResponseEntity<Integer> addMember(MemberDto resource) {
        MemberDto member = memberStorage.getMemberById(resource.getId());
        if (member != null) {
            return ResponseEntity.badRequest().build();
        }
        memberStorage.addMember(resource);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity deleteMember(Integer id) {
        MemberDto member = memberStorage.getMemberById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        memberStorage.removeMember(id);
        return ResponseEntity.noContent().build();
    }
}
