package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validator for time entry
 * 
 * @author Safubi
 * @since upcoming version
 * @category Validators
 *
 */
@SuppressWarnings("rawtypes")
@FacesValidator("EntryValidator")
public class EntryValidator implements Validator {

	/**
	 * Method to validate entry field
	 * 
	 * @author Safubi
	 * @since upcoming version
	 * @param arg0
	 *            context of the web application
	 * @param arg1
	 *            component on which validation is made
	 * @param arg2
	 *            value of the component to be validated
	 * @throws ValidatorException
	 *             when validation condition is met
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		try {
			double entry = Double.parseDouble(String.valueOf(arg2));
			if (entry % 0.5 != 0) {
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"Entry must be a multiple of 0.5");
				throw new ValidatorException(facesMessage);
			}
		} catch (ClassCastException castException) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Entry must be a number.");
			throw new ValidatorException(message);
		}
	}

}
