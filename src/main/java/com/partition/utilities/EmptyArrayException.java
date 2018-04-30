package com.partition.utilities;

/**
 * Empty Array with no values Exception
 * @author saadtouhbi
 *
 */
public class EmptyArrayException extends Exception {


	public EmptyArrayException() { super(); }
	public EmptyArrayException(String message) { super(message); }
	public EmptyArrayException(String message, Throwable cause) { super(message, cause); }
	public EmptyArrayException(Throwable cause) { super(cause); }
}
