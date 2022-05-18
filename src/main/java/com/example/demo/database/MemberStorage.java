package com.example.demo.database;

import com.example.demo.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A Fake Class written to imitate a Database
 */
public class MemberStorage {
    private List<MemberDto> dataList;

    public MemberStorage() {
        dataList = new ArrayList<>();

        MemberDto mem1 = new MemberDto();
        mem1.setId(1);
        mem1.setNicNo("N79070801");
        mem1.setDob("2012/08/14");
        mem1.setPreferredName("Nimal Gunarathne");

        MemberDto mem2 = new MemberDto();
        mem2.setId(2);
        mem2.setNicNo("N35156845");
        mem2.setDob("2090/08/14");
        mem2.setPreferredName("Kumara Senanayake");
        dataList.add(mem1);
        dataList.add(mem2);
    }

    public List<MemberDto> getAllMembers() {
        return dataList;
    }

    public MemberDto getMemberById(int id) {
        Optional<MemberDto> selectedMember = dataList.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        return selectedMember.isPresent() ? selectedMember.get() : null;
    }

    public void updateMember(Integer id, MemberDto member) {
        Optional<MemberDto> selectedMember = dataList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
        dataList.remove(selectedMember.get());
        dataList.add(member);
    }

    public void addMember(MemberDto member) {
        dataList.add(member);
    }

    public void removeMember(Integer id) {
        Optional<MemberDto> selectedMember = dataList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
        dataList.remove(selectedMember.get());
    }
}
