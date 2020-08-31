package br.edu.ufcg.pracadasprofissoes.escola.dtos;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.edu.ufcg.pracadasprofissoes.escola.Escola;

@Component("escolaIO")
public class EscolaIO {
	
	private ModelMapper modelMapper;
	
	final Converter<EscolaInput, Escola> escolaInputConverter = new Converter<EscolaInput, Escola>(){
		
		@Override
		public Escola convert(MappingContext<EscolaInput, Escola> context) {
			EscolaInput escolaInput = context.getSource();
			Escola escola = new Escola();
			escola.setNome(escolaInput.getNome());
			escola.setSigla(escolaInput.getSigla());
			escola.setCnpj(escolaInput.getCnpj());
			escola.setTelefone(escolaInput.getTelefone());
			escola.setDiretor(escolaInput.getDiretor());
			escola.setUsuario(escolaInput.getUsuario());
			escola.setEndereco(escolaInput.getEndereco());
			
			return escola;			
		}
		
	};
	
	final Converter<Escola, EscolaOutput> escolaOutputConverter = new Converter<Escola, EscolaOutput>(){
		
		@Override
		public EscolaOutput convert(MappingContext<Escola, EscolaOutput> context) {
			Escola escola = context.getSource();
			EscolaOutput escolaOutput = new EscolaOutput();
			escolaOutput.setId(escola.getId());
			escolaOutput.setNome(escola.getNome());
			escolaOutput.setCnpj(escola.getCnpj());
			escolaOutput.setTelefone(escola.getTelefone());
			escolaOutput.setDiretor(escola.getDiretor());
			escolaOutput.setEndereco(escola.getEndereco());
			
			return escolaOutput;
		}
	};
	
	
	public EscolaIO() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.addConverter(escolaInputConverter);
		this.modelMapper.addConverter(escolaOutputConverter);
	}
	
	public Escola mapTo(EscolaInput escolaInput) {
		return this.modelMapper.map(escolaInput, Escola.class);
	}
	
	public EscolaOutput mapTo(Escola escola) {
		return this.modelMapper.map(escola, EscolaOutput.class);
	}
}
