package br.senai.sp.romvc.controller;



//imports

import br.senai.sp.romvc.model.*;
import br.senai.sp.romvc.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;



    @GetMapping("/listagem")

    public String listagem(Model model) {

        // Busca a lista de alunos no banco de dados
        List<Aluno> listaAlunos = alunoRepository.findAll();

        // Adiciona a lista de alunos no objeto model para ser carregado no template
        model.addAttribute("alunos", listaAlunos);

        // Retorna o template aluno/listagem.html
        return "alunos/listagem";
    }


    @GetMapping("/inserir")
    public String cadastrar(Model model) {

        // Adiciona um objeto aluno vazio para
        // ser carregado no formulário
        model.addAttribute("aluno", new Aluno());


        // Retorna o template aluno/inserir.html
        return "alunos/inserir";
    }



   // @GetMapping("/form-alterar/{id}")
    //public String formAlterar(@PathVariable("id") Long id, Model model){
      //  model.addAttribute("aluno", alunoRepository.findById(id).get());
        //return "alunos/form-alterar";
    //}

    @PostMapping("/salvar")
    public String salvar(
            @Valid Aluno aluno,
            BindingResult result,
            RedirectAttributes attributes
    ) throws IOException
    {

        if(result.hasErrors()){
            return "alunos/inserir";
        }

        alunoRepository.save(aluno);  // <<<<<<<< AQUI!


        attributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");

        return "redirect:/aluno/listagem";
    }

@GetMapping("/excluir/{id}")
public String excluir(@PathVariable("id") Long id, RedirectAttributes attributes) {
    alunoRepository.deleteById(id);
    attributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
    return "redirect:/aluno/listagem";

}
@GetMapping("/alterar/{id}")
public String alterar(@PathVariable("id") Long id, Model model) {
    Aluno aluno = alunoRepository.findById(id).orElse(null);
    if (aluno != null) {
        model.addAttribute("aluno", aluno);
        return "alunos/alterar";
    } else {
        return "redirect:/aluno/listagem";
    }

}

@PostMapping("/buscar")
public String buscar(@Valid Aluno aluno, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "alunos/listagem";
    }

    List<Aluno> listaAlunos = alunoRepository.findByNomeContainingIgnoreCase(aluno.getNome());
    model.addAttribute("alunos", listaAlunos);

    return "alunos/listagem";

}}