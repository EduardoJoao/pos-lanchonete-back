package com.core.lanchonete.domain.pedido.worflow.activity;

import com.core.lanchonete.adapters.repository.FilaCozinhaDBRepository;
import com.core.lanchonete.domain.pedido.model.FilaCozinhaDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicaFilaCozinhaActivity {

    private final FilaCozinhaDBRepository filaCozinhaDBRepository;

    public void publicaFilaCozinha(FilaCozinhaDB filaCozinhaDB){
        filaCozinhaDBRepository.save(filaCozinhaDB);
    }
}
