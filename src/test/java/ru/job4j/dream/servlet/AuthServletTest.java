package ru.job4j.dream.servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class AuthServletTest {
        @Test
        public void whenAuth() throws IOException, ServletException {
            Store store = MemStore.instOf();
            PowerMockito.mockStatic(PsqlStore.class);
            when(PsqlStore.instOf()).thenReturn(store);
            HttpServletRequest req = mock(HttpServletRequest.class);
            HttpServletResponse resp = mock(HttpServletResponse.class);
            HttpSession sc = mock(HttpSession.class);
            when(req.getSession()).thenReturn(sc);
            when(req.getParameter("email")).thenReturn("root@root.com");
            when(req.getParameter("password")).thenReturn("root");
            User actual = store.findUserByEmail("root@root.com");
            new AuthServlet().doPost(req, resp);
            assertEquals("root@root.com", actual.getEmail());
        }
    }
