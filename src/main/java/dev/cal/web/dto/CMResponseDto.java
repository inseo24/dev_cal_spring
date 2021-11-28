package dev.cal.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMResponseDto<T> {
	
	private int code; // 1 ����, -1 ����
	private String message;
	private T data;
	
}
