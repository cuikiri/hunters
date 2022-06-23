package br.com.jhisolution.user.hunters.service.impl;

import br.com.jhisolution.user.hunters.domain.Aviso;
import br.com.jhisolution.user.hunters.repository.AvisoRepository;
import br.com.jhisolution.user.hunters.service.AvisoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Aviso}.
 */
@Service
@Transactional
public class AvisoServiceImpl implements AvisoService {

    private final Logger log = LoggerFactory.getLogger(AvisoServiceImpl.class);

    private final AvisoRepository avisoRepository;

    public AvisoServiceImpl(AvisoRepository avisoRepository) {
        this.avisoRepository = avisoRepository;
    }

    @Override
    public Aviso save(Aviso aviso) {
        log.debug("Request to save Aviso : {}", aviso);
        return avisoRepository.save(aviso);
    }

    @Override
    public Aviso update(Aviso aviso) {
        log.debug("Request to save Aviso : {}", aviso);
        return avisoRepository.save(aviso);
    }

    @Override
    public Optional<Aviso> partialUpdate(Aviso aviso) {
        log.debug("Request to partially update Aviso : {}", aviso);

        return avisoRepository
            .findById(aviso.getId())
            .map(existingAviso -> {
                if (aviso.getData() != null) {
                    existingAviso.setData(aviso.getData());
                }
                if (aviso.getTitulo() != null) {
                    existingAviso.setTitulo(aviso.getTitulo());
                }
                if (aviso.getConteudo() != null) {
                    existingAviso.setConteudo(aviso.getConteudo());
                }

                return existingAviso;
            })
            .map(avisoRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Aviso> findAll(Pageable pageable) {
        log.debug("Request to get all Avisos");
        return avisoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aviso> findOne(Long id) {
        log.debug("Request to get Aviso : {}", id);
        return avisoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Aviso : {}", id);
        avisoRepository.deleteById(id);
    }
}
