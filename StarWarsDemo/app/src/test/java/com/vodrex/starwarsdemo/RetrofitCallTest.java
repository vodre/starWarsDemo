package com.vodrex.starwarsdemo;

import com.vodrex.starwarsdemo.adapters.CharactersListAdapter;
import com.vodrex.starwarsdemo.rest.plates.Character;
import com.vodrex.starwarsdemo.rest.services.StarWarsEndPointInterface;
import com.vodrex.starwarsdemo.view.CharactersListActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;

/**
 * Created by vodrex on 10/10/16.
 */
@Config(constants = BuildConfig.class, sdk = 21,
        manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricGradleTestRunner.class)
public class RetrofitCallTest {

    private CharactersListActivity mActivity;

    @Mock
    private StarWarsEndPointInterface mockRetrofitApiImpl;

    @Captor
    private ArgumentCaptor<Callback<List<Character>>> callbackArgumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ActivityController<CharactersListActivity> controller = Robolectric.buildActivity(CharactersListActivity.class);
        mActivity = controller.get();

        controller.create();
    }

    @Test
    public void shouldFillAdapter() throws Exception {
        Mockito.verify(mockRetrofitApiImpl).getCharacters();


        int objectsQuantity = 10;
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < objectsQuantity; ++i) {
            list.add(new Character());
        }

        CharactersListAdapter adapter = (CharactersListAdapter) mActivity.getListAdapter();
        assertEquals(adapter.getCount(), objectsQuantity);
    }
}

