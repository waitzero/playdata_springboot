package com.simple.bootbasic.command;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidVO {

	//유효성 검사를 진행할때는 기본타입이 null값을 가질수 없기 때문에
	//wrapper형으로 선언해줍니다.
	/*
	 * @NotBlank - 공백과, null을 허용하지 않음 (String에 적용)
	 * @NotNull - null을 허용하지 않음 (String, Integer, Double...)
	 * @NotEmpty - null을 허용하지 않음 ( Map, List, Array...)
	 * @Pattern - 정규표현식에 위배되면 허용하지 않음
	 */
	
	@NotBlank(message = "이름은 필수 입니다")
	private String name;
	
	@NotNull(message = "급여는 필수 입니다")
	private Integer salary;
	@Pattern(regexp = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}", message = "000-0000-0000형식 이어야 합니다")
	private String phone;
	
	@NotBlank
	@Email(message = "이메일 형식이어야 합니다") //공백은 통과
	private String email;
	
	
}
