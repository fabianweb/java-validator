package io.fabiandev.validator.rules;

import io.fabiandev.validator.core.BaseRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex extends BaseRule
{

    @Override
    protected void validate()
    {
        if (this.inputField.getValue().length() <= 0)
        {
            return;
        }

        Pattern pattern = Pattern.compile(this.regex());
        Matcher matcher = pattern.matcher(this.inputField.getValue());

        if (!matcher.matches())
        {
            this.fail();
        }
    }

    protected String regex()
    {
        return this.ruleValue;
    }

    @Override
    protected String defaultMessage()
    {
        return ":field is not a valid Email.";
    }

}
