package com.fabianesilva.estoque_material.business;

import com.fabianesilva.estoque_material.infrastructure.entities.Empresa;
import com.fabianesilva.estoque_material.infrastructure.repositories.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService (EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    public void salvarEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }

    public List<Empresa> buscarEmpresa(){
        return empresaRepository.findAll();
    }

    public Empresa buscarEmpresaPorId(UUID id){
        return empresaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!" + id));
    }

    public Empresa buscarEmpresaPorEmail(String email){
        return empresaRepository.findByEmail(email).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não encontrado!" + email));
    }

    public void deletarEmpresaPorId(UUID id){
        empresaRepository.deleteById(id);
    }

    public void deletarEmpresaPorEmail(String email){
        empresaRepository.deleteByEmail(email);
    }

    public void atualizarEmpresaPorId(UUID id, Empresa empresa){
        Empresa empresaEntity = empresaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Id não encontrado" + id));
        Empresa empresaAtualizada = Empresa.builder()
                .nome(empresa.getNome() != null ? empresa.getNome() : empresaEntity.getNome())
                .cnpj(empresa.getCnpj() != null ? empresa.getCnpj() : empresaEntity.getCnpj())
                .email(empresa.getEmail() != null ? empresa.getEmail() : empresaEntity.getEmail())
                .website(empresa.getWebsite() != null ? empresa.getWebsite() : empresaEntity.getWebsite())
                .descricao(empresa.getDescricao() != null ? empresa.getDescricao() : empresaEntity.getDescricao())
                .build();

        empresaRepository.save(empresaAtualizada);

    }
}
