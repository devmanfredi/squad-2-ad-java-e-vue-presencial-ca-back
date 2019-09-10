package br.com.codenation.logstackapi.controller;

import br.com.codenation.logstackapi.dto.TriggerCreateDTO;
import br.com.codenation.logstackapi.dto.ErrorMessageDTO;
import br.com.codenation.logstackapi.model.entity.Trigger;
import br.com.codenation.logstackapi.service.impl.TriggerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Triggers")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class TriggerController {

    private TriggerServiceImpl service;

    @ApiOperation(
            value = "Cria um novo gatilho",
            notes = "Método utilizado para criar um novo."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Gatilho criado", response = Trigger.class),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ErrorMessageDTO.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ErrorMessageDTO.class)
    })
    @PostMapping(value = "/triggers", produces = MediaType.APPLICATION_JSON_VALUE)
    private Trigger save(@Valid @RequestBody TriggerCreateDTO dto) {
        return service.save(dto);
    }

    @ApiOperation(
            value = "Recupera todos os gatilhos cadastrados",
            notes = "Método utilizado para recuperar todos os Triggeras cadastrados."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Trigger.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Requisição mal formatada", response = ErrorMessageDTO.class),
            @ApiResponse(code = 500, message = "Erro na api", response = ErrorMessageDTO.class)
    })
    @GetMapping(value = "/triggers", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Trigger> findAll() {
        return service.findAll();
    }

}