package algorithms.book.core;

/**
 * An asymptotic complexity expression. *
 * 
 * @author Amrinder Arora
 */
public class ComplexityExpression {
	double base = 1;
	double exponent;
	double[] logExponents;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getExponent() {
		return exponent;
	}

	public void setExponent(double exponent) {
		this.exponent = exponent;
	}

	public double[] getLogExponents() {
		return logExponents;
	}

	public void setLogExponents(double[] logExponents) {
		this.logExponents = logExponents;
	}
}
