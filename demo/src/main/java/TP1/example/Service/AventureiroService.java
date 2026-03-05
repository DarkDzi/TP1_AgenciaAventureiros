package TP1.example.Service;

import TP1.example.Domain.Aventureiro;
import TP1.example.Domain.Classe;
import TP1.example.Domain.StatusAventureiro;
import TP1.example.Repository.AventureiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AventureiroService {
    private final AventureiroRepository repository;

    public List<Aventureiro> ListarTodos() {
        return repository.findAll();
    }
    public List<Aventureiro> ListarPorClasse(Classe classe){
        return repository.findByClasse(classe);
    }
    public List<Aventureiro> ListaPorNivelMaiorQue(Integer nivel){
        return repository.findByNivelGreaterThan(nivel);
    }
    public List<Aventureiro> ListarPorStatus(StatusAventureiro status){
        return repository.findByStatus(status);
    }

    public Aventureiro BuscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    public Aventureiro Salvar(Aventureiro aventureiro) {
        return repository.save(aventureiro);
    }
    public void Deletar(Long id) {
        repository.deleteById(id);
    }

}
