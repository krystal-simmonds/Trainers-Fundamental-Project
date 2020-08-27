package com.qa.trainers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A shoe with that ID does not exist")
public class ShoeNotFoundException extends EntityNotFoundException {
}
