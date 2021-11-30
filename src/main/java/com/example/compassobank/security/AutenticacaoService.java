package com.example.compassobank.security;

import com.example.compassobank.entity.Associado;
import com.example.compassobank.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private AssociadoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Associado> associadoCpf = repository.findbyCpf(username);
        Optional<Associado> associadoCnpj = repository.findbyCnpj(username);
        if (associadoCnpj.isPresent()){
            return associadoCnpj.get();
        } else if (associadoCpf.isPresent()){
            return associadoCpf.get();
        }
        throw new UsernameNotFoundException("dados invalidos");
    }
}
