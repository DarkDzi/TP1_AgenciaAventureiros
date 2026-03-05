package TP1.example.Service;

import TP1.example.Domain.Aventureiro;
import TP1.example.Domain.Classe;
import TP1.example.Domain.Companheiro;
import TP1.example.Domain.StatusAventureiro;
import TP1.example.Repository.AventureiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AventureiroService {
    private final AventureiroRepository repository;

    public List<Aventureiro> ListarTodos() {
        return repository.findAll();
    }
    //TODO Implementar no Controller
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
    //TODO Reduzir repetição de código aqui e implementar no controller
    public void AtualizarNome(Long id, String nome){
        Optional<Aventureiro> aventureiroOpt = repository.findById(id);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setNome(nome);
            repository.save(aventureiroMod);
        }


    }
    public void AtualizarClasse(Long id, Classe classe){
        Optional<Aventureiro> aventureiroOpt = repository.findById(id);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setClasse(classe);
            repository.save(aventureiroMod);
        }


    }
    public void AtualizarNivel(Long id, Integer nivel){
        Optional<Aventureiro> aventureiroOpt = repository.findById(id);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setNivel(nivel);
            repository.save(aventureiroMod);
        }


    }
    public void EncerrarVinculo(Long id){
        Optional<Aventureiro> aventureiroOpt = repository.findById(id);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setStatus(StatusAventureiro.INATIVO);
            repository.save(aventureiroMod);
        }


    }
    public void RecrutarNovamente(Long id){
        Optional<Aventureiro> aventureiroOpt = repository.findById(id);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setStatus(StatusAventureiro.ATIVO);
            repository.save(aventureiroMod);
        }


    }
    public void DefinirCompanheiro(Long aventureiroid, Companheiro companheiro){
        Optional<Aventureiro> aventureiroOpt = repository.findById(aventureiroid);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setCompanheiro(companheiro);
            repository.save(aventureiroMod);
        }

    }
    public void RemoveCompanheiro(Long aventureiroid, Companheiro companheiro ){
        Optional<Aventureiro> aventureiroOpt = repository.findById(aventureiroid);
        if(aventureiroOpt.isPresent()) {
            Aventureiro aventureiroMod = aventureiroOpt.get();
            aventureiroMod.setCompanheiro(null);
            repository.save(aventureiroMod);
        }
    }
}
