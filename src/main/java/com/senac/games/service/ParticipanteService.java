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
    }


    public ParticipanteDTOResponse atualizarParticipante(Integer participanteId, ParticipanteDTORequest participanteDTORequest) {
        //antes de atualizar busca se existe o registro a se atualizar
        Participante participante = this.listarPorParticipanteId(participanteId);
        //se encontra o registro a ser atualizado
        if (participante != null) {
            //copia os dados a serem atualizados do DTO de entrada para um objeto do tipo participante
            //que é compativel com o repository para atualizar
            Participante participanteUpdate = modelMapper.map(participanteDTORequest, Participante.class);

            //com o objeto no formato correto "participante"
            Participante tempResponse = participanteRepository.save(participanteUpdate);

            return modelMapper.map(tempResponse, ParticipanteDTOResponse.class);
        }else {
            return null;
        }
    }
}
