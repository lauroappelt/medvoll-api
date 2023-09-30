package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
