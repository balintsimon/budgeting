package com.drbalintsimon.api.util;

import com.drbalintsimon.api.service.dao.VisitorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class PatternUtilTest {
    @MockBean
    private VisitorDAO visitorDao;

    @Autowired
    private PatternUtil patternUtil;

    @Test
    public void testValidEmail() {
        String email = "donald@rumsfeld.com";
        boolean expected = true;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testTwoDotsInTrailEmail() {
        String email = "donald@rumsfeld.co.in";
        boolean expected = true;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testValidSpecialCharactersInEmail() {
        String email = "donald.rumsfeld-com@rumsfeld.co.in";
        boolean expected = true;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNoNameInEmail() {
        String email = "@rumsfeld.com";
        boolean expected = false;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNoAtInEmail() {
        String email = "donaldrumsfeld.com";
        boolean expected = false;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testServeralAtInEmail() {
        String email = "donald@@rumsf@eld.com";
        boolean expected = false;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNoDotInEmail() {
        String email = "donald@rumsfeldcom";
        boolean expected = false;

        boolean actual = patternUtil.isValidEmail(email);

        assertThat(actual).isEqualTo(expected);
    }
}