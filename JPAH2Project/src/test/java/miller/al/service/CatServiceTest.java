package miller.al.service;

import miller.al.model.Cat;
import miller.al.model.EyeColour;
import miller.al.model.FurColour;
import miller.al.repository.CatRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatServiceTest {

    @Mock
    private CatRepository mockCatRepository;

    private CatService catService;

    private static final String CAT_NAME = "Test Cat";
    private static final Integer CAT_AGE = 10;
    private static final EyeColour EYE_COLOUR = EyeColour.BLUE;
    private static final FurColour FUR_COLOUR = FurColour.BLACK;
    private static final Cat TEST_CAT = Cat.builder()
            .name(CAT_NAME)
            .age(CAT_AGE)
            .eyeColour(EYE_COLOUR)
            .furColour(FUR_COLOUR)
            .build();

    @Before
    public void setUp() {
        catService = new CatService(mockCatRepository);
    }

    @Test
    public void testCreateNewCat() {
        catService.createNewCat(CAT_NAME, CAT_AGE, EYE_COLOUR, FUR_COLOUR);

        verify(mockCatRepository).createOne(TEST_CAT);
    }

    @Test
    public void testUpdateNewCat() {
        catService.updateNewCat(CAT_NAME, CAT_AGE, EYE_COLOUR, FUR_COLOUR);

        verify(mockCatRepository).updateOne(Cat.builder()
                .name(CAT_NAME)
                .age(CAT_AGE)
                .eyeColour(EYE_COLOUR)
                .furColour(FUR_COLOUR)
                .build());
    }

    @Test
    public void testGetCatByName() {
        when(mockCatRepository.findOneByName(CAT_NAME)).thenReturn(TEST_CAT);

        assertThat(catService.getCatByName(CAT_NAME)).isEqualTo(Optional.of(TEST_CAT));
    }

    @Test
    public void testDeleteCatByName() {
        catService.deleteCatByName(CAT_NAME);

        verify(mockCatRepository).deleteOneByName(CAT_NAME);
    }
}