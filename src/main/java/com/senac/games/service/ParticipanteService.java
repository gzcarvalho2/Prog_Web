package com.senac.games.service;

import com.senac.games.dto.request.ParticipanteDTORequest;
import com.senac.games.dto.response.ParticipanteDTOResponse;
import com.senac.games.entity.Participante;
import com.senac.games.repository.ParticipanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public List<Participante> listarParticipantes(){
        return this.participanteRepository.findAll();


    }

    public Participante listarPorParticipanteId(Integer participanteId) {
        return this.participanteRepository.findById(participanteId).orElse(null);
    }

    public ParticipanteDTOResponse criarParticipante(ParticipanteDTORequest participanteDTORequest) {

        Participante participante = modelMapper.map(participanteDTORequest, Participante.class);
        Participante participanteSave = this.participanteRepository.save(participante);
        ParticipanteDTOResponse participanteDTOResponse = modelMapper.map(participanteSave, ParticipanteDTOResponse.class);
        return participanteDTOResponse;

        /*
        participante.setNome(participanteDTO.getNome());
        participante.setEmail(participanteDTO.getEmail());
        participante.setIdentificacao(participanteDTO.getIdentificacao());
        participante.setEndereco(participanteDTO.getEndereco());
        participante.setStatus(participanteDTO.getStatus());
        */


        /*
        participanteDTOResponse.setId(participanteSave.getId());
        participanteDTOResponse.setEmail(participanteSave.getEmail());
        participanteDTOResponse.setNome(participanteSave.getNome());
        participanteDTOResponse.setIdentificacao(participanteSave.getIdentificacao());
        participanteDTOResponse.setEndereco(participanteSave.getEndereco());
        participanteDTOResponse.setStatus(participanteSave.getStatus());
        */

    }
}
