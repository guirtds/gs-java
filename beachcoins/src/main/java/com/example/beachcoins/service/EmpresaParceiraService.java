package com.example.beachcoins.service;

import com.example.beachcoins.controller.dto.EmpresaParceiraDTO;
import com.example.beachcoins.model.EmpresaParceira;
import com.example.beachcoins.model.Imagens;
import com.example.beachcoins.repository.EmpresaParceiraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaParceiraService {

    @Autowired
    private EmpresaParceiraRepository empresaParceiraRepository;

    // Cadastrando a empresa parceira

    public EmpresaParceira cadastrarEmpresaParceira(EmpresaParceiraDTO empresaParceiraDTO) {
        EmpresaParceira empresaParceira = new EmpresaParceira();
        empresaParceira.setRazaoSocial(empresaParceiraDTO.getRazaoSocial());
        empresaParceira.setCnpj(empresaParceiraDTO.getCnpj());
        empresaParceira.setNomeFantasia(empresaParceiraDTO.getNomeFantasia());
        return empresaParceiraRepository.save(empresaParceira);
    }

    // Atualizando a empresa parceira

    public EmpresaParceira atualizarEmpresaParceira(Long id, EmpresaParceiraDTO novaEmpresaParceira) {
        Optional<EmpresaParceira> empresaParceiraExistente = empresaParceiraRepository.findById(id);

        if(empresaParceiraExistente.isPresent()) {
            EmpresaParceira empresaParceiraAtualizada = empresaParceiraExistente.get();
            empresaParceiraAtualizada.setRazaoSocial(novaEmpresaParceira.getRazaoSocial());
            empresaParceiraAtualizada.setCnpj(novaEmpresaParceira.getCnpj());
            empresaParceiraAtualizada.setNomeFantasia(novaEmpresaParceira.getNomeFantasia());
            return empresaParceiraRepository.save(empresaParceiraAtualizada);
        } else {
            throw new RuntimeException("Empresa parceira não encontrada com o ID: " + id);
        }
    }

    // Listando as empresas parceiras

    public List<EmpresaParceira> listarEmpresasParceiras() {
        return empresaParceiraRepository.findAll();
    }

    // Deletando as empresas parceiras

    public void removerEmpresasParceiras(Long id) {
        if (empresaParceiraRepository.existsById(id)) {
            empresaParceiraRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empresa parceira não encontrada com o ID: " + id);
        }
    }

    @Transactional
    public Optional<EmpresaParceira> buscarPorId(Long id) { return empresaParceiraRepository.findById(id); }
}
