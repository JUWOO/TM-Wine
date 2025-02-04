import { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Box, Button, CircularProgress, Divider, Grid, Modal } from '@mui/material';
import { makeStyles } from '@mui/styles';
import AnimateButton from '../../../../ui-component/extended/AnimateButton';
import { wineInfoByImageAction } from '../../../../store/reducers/wine';
import WineRecommendationDialog from '../WineRecommendationDialog';
import CameraModal from '../../../../ui-component/CameraModal';

const styledImage = makeStyles({
    root: {
        position: 'relative',
        display: 'block',
        height: '80vh',
        border: '1px #fff solid',
        fontSize: 30,
        '& img': {
            position: 'absolute',
            height: '100%',
            minHeight: '500px',
            objectFit: 'cover',
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)'
        }
    }
});

const styledInput = makeStyles({
    root: {
        fontSize: 30,
        padding: '31px 0',
        display: 'block',
        width: '100%',
        marginTop: '8px',
        backgroundColor: '#B0A8B9',
        borderRadius: 5,
        textAlign: 'center',
        border: 'none',
        color: 'white',
        textDecoration: 'none',
        cursor: 'pointer',
        fontFamily: 'BlackhanSans'
    }
});

const WineLabelImage = () => {
    const classes = styledImage();
    const inputClasses = styledInput();
    const [fileList, setFileList] = useState('');
    const [openModal, setOpenModal] = useState(false);
    const dispatch = useDispatch();
    const loadWineInfoLoading = useSelector((state) => state.wine.loadWineInfoLoading);
    const onLoadFile = (e) => {
        const file = e.target.files;
        setFileList(file);
    };

    useEffect(() => {
        preview();
    }, [fileList]);

    useEffect(() => {
        preview();
    });

    const preview = () => {
        console.log(fileList.length);
        if (!fileList || !fileList.length) return false;
        const imgEl = document.getElementById('img__box');
        imgEl.removeChild(imgEl.childNodes[0]);
        const newImgTag = document.createElement('img');
        newImgTag.src = window.URL.createObjectURL(fileList[0]);
        imgEl.appendChild(newImgTag);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!fileList || !fileList.length) {
            alert('이미지를 업로드 해주세요');
            return false;
        }
        dispatch(wineInfoByImageAction(fileList[0]));
    };

    const a = () => {
        setOpenModal(true);
    };

    return (
        <>
            <Grid container direction="column" justifyContent="center" spacing={2}>
                <Grid item xs={12}>
                    <div className="custom__img">
                        <div className={classes.root} id="img__box">
                            <p style={{ textAlign: 'center', margin: '50px' }}>
                                <h3 style={{ fontFamily: 'BlackhanSans', color: '#B0A8B9' }}>와인 라벨 사진을 업로드 하세요:)</h3>
                            </p>
                        </div>
                    </div>
                    <Grid container style={{ justifyContent: 'center' }}>
                        <AnimateButton>
                            <form className="upload__input" style={{ width: 350, marginRight: '5px', display: 'inline-block' }}>
                                <label className={inputClasses.root} for="inputImage">
                                    파일 업로드
                                    <input type="file" id="inputImage" accept="img/*" onChange={onLoadFile} style={{ display: 'none' }} />
                                </label>
                            </form>
                        </AnimateButton>
                        <AnimateButton>
                            <span className="" style={{ width: 350, marginRight: '5px', display: 'inline-block' }}>
                                <label className={inputClasses.root} for="a">
                                    사진 촬영
                                    <input id="a" style={{ display: 'none' }} onClick={a} />
                                </label>
                            </span>
                        </AnimateButton>
                    </Grid>
                </Grid>
                <Grid item xs={12}>
                    <Box
                        sx={{
                            alignItems: 'center',
                            display: 'flex'
                        }}
                    >
                        <Divider sx={{ flexGrow: 1 }} orientation="horizontal" />
                    </Box>
                    <form noValidate onSubmit={handleSubmit}>
                        <Box sx={{ textAlign: 'center', marginTop: 2 }}>
                            <AnimateButton>
                                <Button
                                    disableElevation
                                    fullWidth
                                    type="submit"
                                    variant="contained"
                                    style={{ width: 350, padding: '12px 0', borderRadius: 5, backgroundColor: '#B0A8B9' }}
                                >
                                    <span style={{ fontFamily: 'BlackhanSans', fontSize: 30 }}>추천받기</span>
                                </Button>
                            </AnimateButton>
                        </Box>
                    </form>
                </Grid>
            </Grid>
            {loadWineInfoLoading && (
                <Modal open={true} aria-labelledby="modal-modal-title" aria-describedby="modal-modal-description">
                    <div style={{ display: 'flex', justifyContent: 'center', marginTop: '200px' }}>
                        <CircularProgress />
                    </div>
                </Modal>
            )}
            {openModal && <CameraModal setFileList={setFileList} preview={preview} setOpenModal={setOpenModal} />}
            <WineRecommendationDialog />
        </>
    );
};

export default WineLabelImage;
