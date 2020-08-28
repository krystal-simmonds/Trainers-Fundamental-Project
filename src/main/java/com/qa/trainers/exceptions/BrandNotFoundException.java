package com.qa.trainers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A brand with that ID does not exist")
public class BrandNotFoundException extends EntityNotFoundException {
}
