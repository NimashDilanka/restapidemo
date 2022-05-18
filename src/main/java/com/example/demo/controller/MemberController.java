package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-management/")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members")
    public ResponseEntity<List<MemberDto>> getMembers(@RequestParam(required = false, name = "preferredName") String preferredName) {
        return memberService.getMembers(preferredName);
    }

    @GetMapping("members/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Integer id) {
        return memberService.getMember(id);
    }

    @PutMapping("members/{id}")
    public ResponseEntity<Integer> modifyMember(@RequestBody MemberDto resource, @PathVariable Integer id) {
        return memberService.modifyMember(id, resource);
    }

    @PostMapping("members")
    public ResponseEntity<Integer> addMember(@RequestBody MemberDto resource) {
        return memberService.addMember(resource);
    }

    @DeleteMapping("members/{id}")
    public ResponseEntity deleteMember(@PathVariable Integer id) {
        return memberService.deleteMember(id);
    }
}
