package br.com.codenation.logstackapi.service;

import br.com.codenation.logstackapi.dto.request.TriggerRequestDTO;
import br.com.codenation.logstackapi.model.entity.Trigger;
import br.com.codenation.logstackapi.model.enums.LogEnvironment;
import br.com.codenation.logstackapi.model.enums.LogLevel;

import java.util.List;
import java.util.UUID;

public interface TriggerService {

    Trigger save(TriggerRequestDTO dto);

    List<Trigger> findAll();

    Trigger findById(UUID id);

    List<Trigger> findByLog(String appName, LogEnvironment environment, LogLevel level);

    Trigger unarchive(UUID id);

    Trigger archive(UUID id);

    Trigger active(UUID id);

    Trigger inactive(UUID id);

    Trigger update(UUID id, TriggerRequestDTO dto);

}
