package com.nocountry.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nocountry.backend.dto.ExamDto;
import com.nocountry.backend.mapper.ExamMapper;
import com.nocountry.backend.model.Exam;
import com.nocountry.backend.repository.IExamRepository;
import com.nocountry.backend.service.IExamService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements IExamService {

    private final IExamRepository repository;

    private final ExamMapper mapper;

    @Override
    public Optional<ExamDto> getById(Long id) {
        return Optional.ofNullable(mapper.convertEntityToDto(repository.getReferenceById(id)));
    }

    @Override
    public List<ExamDto> getAll() {
        return mapper.convertToDtoList(repository.findAll());
    }

    @Override
    public ExamDto create(ExamDto exam) {
        return mapper.convertEntityToDto(repository.save(mapper.convertDtoToEntity(exam)));
    }

    @Override
    public ExamDto update(ExamDto exam, Long id) {
        Exam updatedExam = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        updatedExam.setName(exam.getName());
        updatedExam.setExamDate(updatedExam.getExamDate());
        updatedExam.setGrammar(updatedExam.getGrammar());
        updatedExam.setListening(updatedExam.getListening());
        updatedExam.setSpeaking(updatedExam.getSpeaking());
        updatedExam.setWriting(updatedExam.getWriting());
        return mapper.convertEntityToDto(repository.save(updatedExam));

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
