package br.com.xavero.projetofinal.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericInterfaceService<T extends RequestDto, R extends ResponseDto, U extends UpdateDto> {
    String insert(T dto);

    Page<R> findAll(Pageable pageable);

    R find(String string);

    void update(U dto);
}
