/*
 * Copyright (c) 2018. Paulino Padial
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.ppadial.testrail.client;

/**
 * Exception raised something goes wrong communicating with TestRail server.
 *
 * <p>The class {@code TestRailException} and its subclasses are a form of {@code Exception} that indicates conditions
 * that a reasonable application might want to catch.</p>
 *
 * <p>The class {@code TestRailException} and any subclasses that are not also subclasses of {@link RuntimeException}
 * are <em>checked exceptions</em>.  Checked exceptions need to be declared in a method or constructor's {@code throws}
 * clause if they can be thrown by the execution of the method or constructor and propagate outside the method or
 * constructor boundary.
 *
 * @author Paulino Padial
 * @see Error
 * @since 0.1.0
 */
public class TestRailException extends Exception {
  private static final long serialVersionUID = 12345600L;

  /**
   * Constructs a new exception with {@code null} as its detail message. The cause is not initialized, and may
   * subsequently be initialized by a call to {@link #initCause}.
   *
   * @since 0.1.0
   */
  public TestRailException() {
    super();
  }

  /**
   * Constructs a new exception with the specified cause and a detail message of <tt>(cause==null ? null :
   * cause.toString())</tt> (which typically contains the class and detail message of <tt>cause</tt>). This constructor
   * is useful for exceptions that are little more than wrappers for other throwables (for example, {@link
   * java.security.PrivilegedActionException}).
   *
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt>
   * value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 0.1.0
   */
  public TestRailException(final Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a new exception with the specified detail message.  The cause is not initialized, and may subsequently
   * be initialized by a call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
   * method.
   * @since 0.1.0
   */
  public TestRailException(final String message) {
    super(message);
  }

  /**
   * Constructs a new exception with the specified detail message and cause.  <p>Note that the detail message associated
   * with {@code cause} is <i>not</i> automatically incorporated in this exception's detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt>
   * value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 0.1.0
   */
  public TestRailException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new exception with the specified detail message, cause, suppression enabled or disabled, and writable
   * stack trace enabled or disabled.
   *
   * @param message the detail message.
   * @param cause the cause.  (A {@code null} value is permitted, and indicates that the cause is nonexistent or
   * unknown.)
   * @param enableSuppression whether or not suppression is enabled or disabled
   * @param writableStackTrace whether or not the stack trace should be writable
   * @since 0.1.0
   */
  protected TestRailException(String message, Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * Constructs a new exception with the specified detail message and cause.  <p>Note that the detail message associated
   * with {@code cause} is <i>not</i> automatically incorporated in this exception's detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
   * @param ex the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value
   * is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 0.1.0
   */
  public TestRailException(String message, Exception ex) {
    super(message, ex);
  }
}
