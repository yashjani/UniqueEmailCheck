package com.unique.email.services;

import java.util.List;


public interface UniqueEmailCheckService {

	public Integer checkUniqueEmailCount(List<String> emailList);

}
